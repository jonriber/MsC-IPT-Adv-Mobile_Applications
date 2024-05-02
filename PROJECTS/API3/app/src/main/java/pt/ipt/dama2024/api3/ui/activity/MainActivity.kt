package pt.ipt.dama2024.api3.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import pt.ipt.dama2024.api3.R
import pt.ipt.dama2024.api3.model.Note
import pt.ipt.dama2024.api3.retrofit.RetrofitIniti
import pt.ipt.dama2024.api3.ui.adapter.NoteListAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.GregorianCalendar
import kotlin.random.Random

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listNotes()

        val bt= findViewById<Button>(R.id.btNewNote)
        bt.setOnClickListener{
            addNewNote()
        }
    }

    /**
     * create a new random note
     */
    private fun addNewNote() {
        val i = Random(GregorianCalendar.getInstance().timeInMillis).nextInt(100)
        val note = Note(0,"NoteXSDSSSDSDSD " + i, "Description $i")

        addNote(note) {
            Toast.makeText(this, "Added " + it?.description, Toast.LENGTH_LONG).show()
            listNotes()

        }
    }

    /**
     *
     * function that adds a new note to the API endpoint
     *
     * @param note
     * @param onResult
     */
    private fun addNote(note: Note, onResult: (Note?) -> Unit) {

        val call = RetrofitIniti().noteService().addNote(note)
        call.enqueue(
            object : Callback<Note> {
                /**
                 * Invoked for a received HTTP response.
                 * Note: An HTTP response may still indicate an application-level failure such as a 404 or 500.
                 * Call [Response.isSuccessful] to determine if the response indicates success.
                 */
                override fun onResponse(call: Call<Note>, response: Response<Note>) {
                    val addedNote = response.body()
                    onResult(addedNote)
                }

                /**
                 * Invoked when a network exception occurred talking to the server or when an unexpected exception
                 * occurred creating the request or processing the response.
                 */
                override fun onFailure(call: Call<Note>, t: Throwable) {
                    t.printStackTrace()
                    onResult(null)
                }

            }
        )
    }

    private fun listNotes() {
        //retrieve API data
        val call = RetrofitIniti().noteService().getNotes()
        // do something with the data
        processList(call)
    }

    /**
     * Proccessing list which was received after using API
     */
    private fun processList(call: Call<List<Note>>) {
        call.enqueue(object : Callback<List<Note>?> {
            override fun onResponse(call: Call<List<Note>?>?,
                                    response: Response<List<Note>?>?) {
                response?.body()?.let {
                    val notes: List<Note> = it
                    configureList(notes)
                }
            }
            override fun onFailure(call: Call<List<Note>?>?, t: Throwable?) {
                t?.printStackTrace()
                t?.message?.let { Log.e("onFailure error", it) }
            }
        })
    }

    private fun configureList(notes: List<Note>) {
        val recyclerView: RecyclerView = findViewById(R.id.noteList)
        recyclerView.adapter = NoteListAdapter(notes, this)
        val layoutManager = StaggeredGridLayoutManager(
            2, StaggeredGridLayoutManager.VERTICAL
        )
        recyclerView.layoutManager = layoutManager
    }
}