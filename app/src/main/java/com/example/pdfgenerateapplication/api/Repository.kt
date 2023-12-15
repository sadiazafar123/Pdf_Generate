package com.example.pdfgenerateapplication.api

import com.example.pdfgenerateapplication.model.StudentEvaluationResponse
import retrofit2.Response

class Repository(private val apiInterface: ApiInterface) {
     suspend fun getStudentEvaluationRecord(params: HashMap<String, String>): Response<StudentEvaluationResponse> {
           return apiInterface.getStudentEvaluationRecord(params)


      }

}