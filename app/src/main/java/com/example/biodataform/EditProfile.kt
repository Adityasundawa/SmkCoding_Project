package com.example.biodataform

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.editprofile.*

class EditProfile : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.editprofile)

        val intentData = intent.extras
        val vnameProfile = intentData.getString("Name")
        val vemailProfile = intentData.getString("Email")
        val vumurProfile = intentData.getString("Umur")
        val vtelpProfile = intentData.getString("Telpon")
        val valamatProfile = intentData.getString("Alamat")

        edNama.setText(vnameProfile)
        edEmail.setText(vemailProfile)
        edUmur.setText(vumurProfile)
        ednoTelpon.setText(vtelpProfile)
        edAlamat.setText(valamatProfile)

        btneditData.setOnClickListener { saveData() }
    }

    private fun saveData() {
        val nameEdit = edNama.text.toString()
        val emailEdit = edEmail.text.toString()
        val umurEdit = edUmur.text.toString()
        val telpEdit = ednoTelpon.text.toString()
        val alamatEdit = edAlamat.text.toString()
        if (!nameEdit.isEmpty() || !emailEdit.isEmpty() || !umurEdit.isEmpty() || !telpEdit.isEmpty() || alamatEdit.isEmpty()){
            val result = Intent()
            result.putExtra("Name", nameEdit)
            result.putExtra("Email", emailEdit)
            result.putExtra("Umur", umurEdit)
            result.putExtra("Telpon", telpEdit)
            result.putExtra("Alamat", alamatEdit)
            setResult(Activity.RESULT_OK, result)

        }else {
            setResult(Activity.RESULT_CANCELED)
        }
        finish()
    }
}