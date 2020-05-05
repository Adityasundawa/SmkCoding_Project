package com.example.biodataform

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.profile.*
import androidx.core.app.ComponentActivity
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.view.WindowManager


class Profile : AppCompatActivity() {

    companion object{
        val REQUEST_CODE = 10000
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.profile)

        getData()

        btnAbout.setOnClickListener{ goToAboutActivity() }

        btnEdit.setOnClickListener { goToEditProfile() }

        btnCall.setOnClickListener { goToCallPhone(txTelp.text.toString()) }
    }

    private fun getData(){
        val data = intent.extras

        val nama = data.getString("Nama")
        val gender = data.getString("Gender")
        val email = data.getString("Email")
        val umur = data.getString("Umur")
        val no = data.getString("No.Telpon")
        val alamat = data.getString("Alamat")

        txNama.text = nama
        txGender.text = gender
        txEmail.text = email
        txUmur.text = umur
        txTelp.text = no
        txAlamat.text = alamat
    }

    private fun goToAboutActivity(){
        val intent = Intent(this, About::class.java)
        startActivity(intent)
    }

    private fun goToEditProfile(){
        val intent = Intent(this,EditProfile::class.java)

        val nameProfile = txNama.text.toString()
        val genderProfile = txGender.toString()
        val emailProfile = txEmail.text.toString()
        val umurProfile = txUmur.text.toString()
        val telpProfile = txTelp.text.toString()
        val alamatProfile = txAlamat.text.toString()

        intent.putExtra("Name", nameProfile)
        intent.putExtra("Gender", genderProfile)
        intent.putExtra("Email", emailProfile)
        intent.putExtra("Umur", umurProfile)
        intent.putExtra("Telpon", telpProfile)
        intent.putExtra("Alamat", alamatProfile)

        startActivityForResult(intent, REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQUEST_CODE){
            if (resultCode == Activity.RESULT_OK) {
                    val resultName = data?.getStringExtra("Name")
                    txNama.text = resultName
                    val resultGender = data?.getStringExtra("Gender")
                    txGender.text = resultGender
                    val resultEmail = data?.getStringExtra("Email")
                    txEmail.text = resultEmail
                    val resultUmur = data?.getStringExtra("Umur")
                    txUmur.text = resultUmur
                    val resultTelp = data?.getStringExtra("Telpon")
                    txTelp.text = resultTelp
                    val resultAlamat = data?.getStringExtra("Alamat")
                    txAlamat.text = resultAlamat
                }
            }else{
                Toast.makeText(this,"Edit Failed", Toast.LENGTH_SHORT).show()
            }
        }

    private fun goToCallPhone(phoneNumber: String) {
        val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
        startActivity(intent)
    }
}
