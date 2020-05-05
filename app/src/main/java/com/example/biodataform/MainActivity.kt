package com.example.biodataform

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.view.WindowManager
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var inputnama : String = ""
    private var selectGender : String = ""
    private var inputEmail : String = ""
    private var inputUmur : String = ""
    private var inputTelpon : String = ""
    private var inputAlamat : String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main)

        setDataSpinnerGender()

        btnSimpan.setOnClickListener{validasiInput()}
    }

    private fun setDataSpinnerGender(){
        val adapter = ArrayAdapter.createFromResource(this,R.array.jenisKelamin, android.R.layout.simple_spinner_item)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        dropjenisKelamin.adapter = adapter
    }

    private fun validasiInput(){
        inputnama = fdNama.text.toString()
        selectGender = dropjenisKelamin.selectedItem.toString()
        inputUmur = fdUmur.text.toString()
        inputEmail = fdEmail.text.toString()
        inputTelpon = fdnoTelpon.text.toString()
        inputAlamat = fdAlamat.text.toString()

        when{
            inputnama.isEmpty() -> fdNama.error = "Nama Harus Diisi"
            selectGender.equals("Pilih Jenis Kelamin", ignoreCase = true) ->
                showToast("Jenis Kelamin Harus Dipilih")
            inputUmur.isEmpty() -> fdUmur.error = "Umur Harus Diisi"
            inputEmail.isEmpty() -> fdEmail.error = "Email Harus Diisi"
            inputTelpon.isEmpty() -> fdnoTelpon.error = "No.telpon Harus Diisi"
            inputAlamat.isEmpty() -> fdAlamat.error = "Alamat Harus Diisi"

            else -> {
                showToast("Data Berhasil Disimpan")
                goToProfileActivity()
            }
        }
    }

    private fun showToast(message: String){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun goToProfileActivity(){
        val intent = Intent(this,Profile::class.java)
        val data = Bundle()
        data.putString("Nama", inputnama)
        data.putString("Gender", selectGender)
        data.putString("Email", inputEmail)
        data.putString("Umur", inputUmur)
        data.putString("No.Telpon", inputTelpon)
        data.putString("Alamat", inputAlamat)

        intent.putExtras(data)
        startActivity(intent)
    }
}
