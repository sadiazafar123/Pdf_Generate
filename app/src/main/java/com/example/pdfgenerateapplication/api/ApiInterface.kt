package com.example.pdfgenerateapplication.api

import com.example.pdfgenerateapplication.Utils.Urls
import com.example.pdfgenerateapplication.model.StudentEvaluationResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiInterface {

    @POST(Urls.STUDENT_EXAM_HISTORY)
     suspend fun getStudentEvaluationRecord(@Body params: HashMap<String, String>): Response<StudentEvaluationResponse>



}