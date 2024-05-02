package pt.ipt.dama2024.api3.retrofit.service

import pt.ipt.dama2024.api3.model.Note
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

/**
 * function description that fetch data from API
 *
 * @constructor Creates empty note service
 */
interface NoteService {

    /**
     * Get All notes from API
     *
     * @return
     */
    @GET("api/notes")
    fun getNotes(): Call<List<Note>>


    /**
     * Post a note to the API route api/notes
     *
     * @param note
     */
    @POST("api/notes")
    fun addNote(@Body note:Note):Call<Note>
}