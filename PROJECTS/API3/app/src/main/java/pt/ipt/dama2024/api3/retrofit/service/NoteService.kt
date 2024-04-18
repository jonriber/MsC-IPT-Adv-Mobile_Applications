package pt.ipt.dama2024.api3.retrofit.service

import pt.ipt.dama2024.api3.model.Note
import retrofit2.Call
import retrofit2.http.GET

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
}