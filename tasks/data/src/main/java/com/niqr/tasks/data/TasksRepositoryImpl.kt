package com.niqr.tasks.data

import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.snapshots
import com.niqr.core.data.FirebaseConstants.DAY
import com.niqr.core.data.FirebaseConstants.DAYS
import com.niqr.core.data.FirebaseConstants.TASKS
import com.niqr.core.data.FirebaseConstants.USERS
import com.niqr.tasks.data.utils.toTimestamp
import com.niqr.tasks.domain.TasksRepository
import com.niqr.tasks.domain.model.Day
import com.niqr.tasks.domain.model.Task
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import java.time.LocalDate
import javax.inject.Inject

class TasksRepositoryImpl @Inject constructor(
    private val auth: FirebaseAuth, //TODO: auth should not be here
    private val db: FirebaseFirestore,
    private val googleClient: GoogleSignInClient
): TasksRepository {
    private val uid = auth.currentUser?.uid ?: ""
    private val userRef = db.collection(USERS).document(uid)
    private val userDaysRef = userRef.collection(DAYS)
    private var dayId: String? = null

    private var flowJob: Job = Job()

    private val _dayFlow = MutableSharedFlow<Day>()
    override val dayFlow = _dayFlow.asSharedFlow()

    override fun updateDay(date: LocalDate) {
        flowJob.cancel()
        flowJob = CoroutineScope(Dispatchers.IO).launch {
            val time = date.toTimestamp()
            val query = userDaysRef
                .whereEqualTo(DAY, time)
                .limit(1)

            query.snapshots().map {
                val doc = it.firstOrNull()
                dayId = doc?.id
                doc?.toObject(Day::class.java)?.copy(date)
                    ?: Day(date, emptyMap())
            }.collect {
                _dayFlow.emit(it)
            }
        }
    }

    override fun addTask(date: LocalDate, task: String) {
        CoroutineScope(Dispatchers.IO).launch {
            dayId ?: suspend {
                dayId = userDaysRef
                    .whereEqualTo(DAY, date.toTimestamp())
                    .limit(1).get().await()
                    .documents.first().id
            }

            if (dayId == null)
                dayId = createDay(date)

            userDaysRef.document(dayId!!).update(
                "$TASKS.$task", false
            ).await()
        }
    }

    override fun updateTaskValue(task: Task) {
        dayId?.let {
            userDaysRef.document(it).update(
                "$TASKS.${task.name}", task.isDone
            )
        }
    }

    override fun updateTask(prevTask: Task, newTask: Task) {
        dayId?.let {
            val day = userDaysRef.document(it)
            day.update("$TASKS.${prevTask.name}", FieldValue.delete())
            day.update("$TASKS.${newTask.name}", newTask.isDone)
        }
    }

    override fun deleteTask(task: String) {
        dayId?.let {
            val day = userDaysRef.document(it)
            day.update("$TASKS.$task", FieldValue.delete())
        }
    }

    override suspend fun signOut(): Boolean {
        return try {
            googleClient.signOut().await()
            auth.signOut()
            true
        } catch (e: Exception) {
            false
        }
    }

    private suspend fun createDay(date: LocalDate): String {
        return userDaysRef.add(
            mapOf(
                DAY to date.toTimestamp(),
                TASKS to emptyMap<String, Boolean>()
            )
        ).await().id
    }
}