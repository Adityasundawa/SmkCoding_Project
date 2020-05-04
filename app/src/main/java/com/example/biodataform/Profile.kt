package com.example.biodataform

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.editprofile.*
import kotlinx.android.synthetic.main.profile.*

class Profile : AppCompatActivity() {

    companion object{
        val REQUEST_CODE = 100
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.profile)

        getData()

        btnAbout.setOnClickListener{ goToAboutActivity() }
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

        val nameProfile = edNama.text.toString()
        val genderProfile = eddropjenisKelamin.selectedItem.toString()
        val emailProfile = edEmail.text.toString()
        val umurProfile = edUmur.text.toString()
        val telpProfile = ednoTelpon.text.toString()
        val alamatProfile = edAlamat.text.toString()

        intent.putExtra("")
    }
}
