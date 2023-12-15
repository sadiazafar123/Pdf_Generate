package com.example.pdfgenerateapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.pdfgenerateapplication.adapter.StudentResultCardAdapter
import com.example.pdfgenerateapplication.api.Globals
import com.example.pdfgenerateapplication.api.Status
import com.example.pdfgenerateapplication.databinding.ActivityMainBinding
import com.example.pdfgenerateapplication.model.EvaluationDetail
import com.example.pdfgenerateapplication.viewModel.PdfViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private val viewModel: PdfViewModel by viewModel()
    private lateinit var binding: ActivityMainBinding
    lateinit var params: HashMap<String, String>
    var userIdentity = "E94Zo5eRQcRoDh1HvDqSYIeYSBHJWdB9"
    var mobileCode = 444
    var month = 3
    var notificationTypeId = 0
    var studentId = 1
    var year = 2023
    private lateinit var evaluationDetail : ArrayList<EvaluationDetail>




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ApiCalling()
        //initViews()
    }

    private fun initViews() {
//        binding.recyclerView.adapter = StudentResultCardAdapter(evaluationDetail)
    }

    private fun ApiCalling() {
        params = HashMap()
        params["UserIdentity"] = userIdentity
        params["MobileCode"] = mobileCode.toString()
        params["Month"] = month.toString()
        params["NotificationTypeId"] = notificationTypeId.toString()
        params["StudentId"] = studentId.toString()
        params["Year"] = year.toString()
        viewModel.getStudentRecord(params).observe(this@MainActivity){ apiResponse ->
            when(apiResponse.status){
                Status.LOADING->{
                    Globals.showProgressDialog(this)
                }
                Status.SUCCESS->{
                    Globals.hideProgressDialog()
                    if (apiResponse.data!= null){
                        evaluationDetail= ArrayList()
                        if (apiResponse.data.code()==200){
                            val topResponse= apiResponse.data.body()
                            topResponse?.let {
                                evaluationDetail.addAll(topResponse.Evaluations)
                            }
                            ///adapter calling
                            binding.parentRecyclerView.adapter = StudentResultCardAdapter(evaluationDetail)

                            Log.d("response"," student record is :$evaluationDetail[0]")
                        }
                        else{
                            Toast.makeText(this@MainActivity, "${apiResponse.data.errorBody()}", Toast.LENGTH_SHORT).show()
                            Log.d("response","else branch: ${apiResponse.data.errorBody()}")
                        }
                    }

                }
                Status.ERROR->{

                }
            }


        }
    }

}