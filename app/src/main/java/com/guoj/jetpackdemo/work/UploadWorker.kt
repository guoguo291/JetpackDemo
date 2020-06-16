package com.guoj.jetpackdemo.work

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import androidx.work.workDataOf
import kotlinx.coroutines.delay

class UploadWorker(context: Context, workerParams: WorkerParameters) :
    Worker(context, workerParams) {
    override fun doWork(): Result {
        Log.i("hello",inputData.getString("info"))
        return Result.success(workDataOf("info" to "来自后台任务的消息"))
    }
}