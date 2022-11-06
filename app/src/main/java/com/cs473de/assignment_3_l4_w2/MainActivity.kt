package com.cs473de.assignment_3_l4_w2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import com.cs473de.assignment_3_l4_w2.models.AndroidVersionModel

class MainActivity : AppCompatActivity() {

    private val list = HashMap<String, AndroidVersionModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        list["Android 9.0"] = AndroidVersionModel("Android 9.0", "Pie")
        list["Android 8.0"] = AndroidVersionModel("Android 8.0", "Oreo")
        list.keys.forEach {
            initialRowView(list[it]!!)
        }
    }

    fun add(view: View) {
        val ver = findViewById<EditText>(R.id.edt_android_version).text.toString()
        val code = findViewById<EditText>(R.id.edt_android_code).text.toString()
        addRow(AndroidVersionModel(ver, code))
    }

    private fun addRow(item: AndroidVersionModel) {
        list[item.ver] = item
        initialRowView(item)
    }

    private fun initialRowView(item: AndroidVersionModel) {
        val row = TableRow(applicationContext)
        val layoutParams = TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT)
        row.layoutParams = layoutParams
        val verTextView = TextView(applicationContext)
        verTextView.layoutParams = findViewById<TextView>(R.id.tv_tr_ver).layoutParams
        val codeTextView = TextView(applicationContext)
        codeTextView.layoutParams = findViewById<TextView>(R.id.tv_tr_code).layoutParams
        verTextView.text = item.ver
        codeTextView.text = item.code
        row.addView(verTextView, 0)
        row.addView(codeTextView, 1)
        findViewById<TableLayout>(R.id.table).addView(row)
    }
}