package pt.ipt.dama2024.api3.model

import com.google.gson.annotations.SerializedName

/**
 * Description of a note that API will send
 *
 * @property id note id
 * @property title note title
 * @property description note content
 * @constructor Create and empty note class
 */
data class Note(
    @SerializedName("id") val id:Number,
    @SerializedName("title") val title:String,
    @SerializedName("description") val description:String
)
