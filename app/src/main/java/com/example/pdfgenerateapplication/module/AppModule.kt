package com.example.pdfgenerateapplication.module

import com.example.pdfgenerateapplication.api.Repository
import com.example.pdfgenerateapplication.viewModel.PdfViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val repositoryModule = module {

    single {
        Repository(get())
    }
}
val viewModelModule = module {
    viewModel {
        PdfViewModel(get())
    }
}
