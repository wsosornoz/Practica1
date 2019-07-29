package com.wsosornoz.sesion1_gui

import android.app.DatePickerDialog
import android.app.Dialog
import android.app.PendingIntent.getActivity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.fragment.app.DialogFragment
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import java.text.SimpleDateFormat
import java.time.Month

class MainActivity : AppCompatActivity() {

    private var sexo = "Masculino"
    private var hobbies = ""
    private var hobbies1 = ""
    private var hobbies2 = ""
    private var hobbies3 = ""
    private var hobbies4 = ""
    private var hobbies5 = ""
    private var date = ""
    private var city = ""
    private var cal = Calendar.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        bFechaNac.setOnClickListener{
            DatePickerDialog(this, dateSetListener,
                cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH),
                cal.get(Calendar.DAY_OF_MONTH)).show()
        }


        bnGuardar.setOnClickListener {
            var nombre = etNombre.text.toString()
            var correo = etCorreo.text.toString()
            var password = etPassword.text.toString()
            var valpassword = etValpassword.text.toString()
            var city = spCiudad.selectedItem.toString()
            var respuesta = ""

            if (nombre.equals("") || correo.equals("") || password.equals("") || valpassword.equals("") ||
                    date.equals("") || hobbies.equals("")){

                Toast.makeText(applicationContext, "Hay un campo vacio", Toast.LENGTH_LONG).show();

            } else {
                if (password.equals(valpassword)){
                    respuesta = "Información:" + "\n\n" + nombre + "\n" + correo + "\n" + sexo + "\n" + "Hobbies: " +
                            hobbies + "\n" + "Fecha de nacimiento: " + date + "\n" + city
                }
               else{
                    Toast.makeText(applicationContext, "Las contraseñas no coinciden", Toast.LENGTH_LONG).show();
                }
            }
            tvResultado.text = respuesta
        }
    }

    val dateSetListener = object : DatePickerDialog.OnDateSetListener {
        override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {

            cal.set(Calendar.YEAR, year)
            cal.set(Calendar.MONTH, month)
            cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)

            val format = "MM/dd/yyyy"
            val sdf = SimpleDateFormat(format, Locale.US)
            date = sdf.format(cal.getTime())
            bFechaNac.setText(date)
            //tvDate.text = date.toString()
        }

    }



    fun onCheckBoxClicked(view: View){
        if(view is CheckBox){
            when (view.id){
                R.id.cbNadar ->
                    if(view.isChecked){
                        hobbies1 =  "Nadar "
                    }
                else {hobbies1=""}

                R.id.cbSeries ->
                    if(view.isChecked){
                        hobbies2 =  "Series "
                    }
                    else {hobbies2=""}

                R.id.cbLeer ->
                    if(view.isChecked){
                        hobbies3 =  "Leer "
                    }
                    else {hobbies3=""}


                R.id.cbCine ->
                    if(view.isChecked){
                        hobbies4 =  "Cine "
                    }
                    else {hobbies4=""}


                R.id.cbOtro ->
                    if(view.isChecked){
                        hobbies5 =  "Otros "
                    }
                    else {hobbies5=""}

            }
            hobbies = hobbies1 + hobbies2 + hobbies3 + hobbies4 + hobbies5
        }
        else{
            hobbies = ""
        }
    }


    fun onRadioButtonClicked(view: View) {

        if (view is RadioButton) {

            when (view.id) {
                R.id.rbMasculino ->
                    if (view.isChecked){
                         sexo = "Masculino"
                }
                R.id.rbFemenino ->
                    if(view.isChecked){
                         sexo = "Femenino"
                    }
            }
        }
    }
}
