package pt.ipt.dama2024.api3.retrofit

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import pt.ipt.dama2024.api3.retrofit.service.NoteService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * This class initializes Retrofit instance
 */
class RetrofitIniti {

    // This object translates JSON content to
    private val gson: Gson = GsonBuilder().setLenient().create()
    private val host = "https://adamastor.ipt.pt/DAM-API/"

    // Opening and stablishing API connection and storing it to a variable
    private val retrofit =
        Retrofit.Builder().baseUrl(host)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

    /**
     * Creates a new NoteService instance
     */
    fun noteService(): NoteService = retrofit.create(NoteService::class.java)
}