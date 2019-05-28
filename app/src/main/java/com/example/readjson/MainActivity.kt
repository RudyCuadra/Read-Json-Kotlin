package com.example.readjson

import android.app.Person
import android.net.sip.SipSession
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import com.example.readjson.Utilities.Persona
import com.google.gson.Gson
import com.google.gson.stream.JsonReader
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONArray
import org.json.JSONObject
import java.io.IOException
import java.io.InputStream

class MainActivity : AppCompatActivity(), View.OnClickListener {


    var homedataList: List<Persona>? = null
    var json:String? = null
    lateinit var gson:Gson

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //EN DONDE ESTABA
        /*gson = Gson()
        json = loadData("data.json")
        Log.d("JSON", json)
        homedataList = gson.fromJson(json, Array<Persona>::class.java).toList()*/


        //val persona:Persona = gson.fromJson(json,Persona::class.java) No sirve porque obtiene un Array y quiere el objeto del JSON


        /*Log.d("HOMEDATA", homedataList!![0].name)
        for ((index, content) in homedataList!!.withIndex()) {

            println(content)
            println(homedataList[index].name)
            println(homedataList[index].category)
            println(homedataList[index].instructions)
        }*/


        //val persona:Persona = gson.fromJson(json,Persona::class.java)
        //Log.d("RES", persona.name[2].toString())


        /*val json:String = "{\"productId\":1,\"name\": \"RudyCuadra\",\"photo\": \"Alguna\",\"instructions\": \"Otras\",\"price\": 20.5,\"category\": \"Guapo\"}"

        val persona:Persona = gson.fromJson(json,Persona::class.java)

        Log.d("resultado",persona.name)*/


    }


    //Funcion que te devuelve el JSON como un string legible
    fun loadData(inFile: String): String {
        var tContents = ""

        try {
            val stream = assets.open(inFile)

            val size = stream.available()
            val buffer = ByteArray(size)
            stream.read(buffer)
            stream.close()
            tContents = String(buffer)
        } catch (e: IOException) {
            //HandleExcepcionHere
        }

        return tContents
    }

    override fun onClick(v: View?) {
        if (v != null) {
            when(v.id){
                R.id.btnRun -> {
                    gson = Gson()
                    json = loadData("data.json")
                    Log.d("JSON", json)
                    homedataList = gson.fromJson(json, Array<Persona>::class.java).toList()
                    //Mostramos en el TextView el JSON
                    tvLog.text = json

                }

                R.id.btnClear -> tvLog.text = ""
            }
        }

    }


}



