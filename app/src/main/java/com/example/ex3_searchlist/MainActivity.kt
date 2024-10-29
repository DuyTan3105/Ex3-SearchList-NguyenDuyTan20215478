package com.example.ex3_searchlist

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ex3_searchlist.adapter.StudentAdapter
import com.example.ex3_searchlist.model.Student


class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: StudentAdapter
    private lateinit var studentList: List<Student>
    private lateinit var filteredList: List<Student>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etSearch = findViewById<EditText>(R.id.etSearch)
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Danh sách sinh viên mẫu
        studentList = listOf(
            Student("Nguyễn Văn A", "123456"),
            Student("Trần Thị B", "654321"),
            Student("Lê Văn C", "789012"),
            Student("Phạm Thị D", "111222"),
            Student("Nguyễn Văn E", "333444"),
            Student("Đỗ Thị F", "555666"),
            Student("Lê Văn G", "777888"),
            Student("Trần Văn H", "999000"),
            Student("Nguyễn Thị I", "222333"),
            Student("Phạm Văn J", "444555"),
            Student("Lê Thị K", "666777"),
            Student("Nguyễn Văn L", "888999"),
            Student("Đinh Văn M", "123123"),
            Student("Vũ Thị N", "456456"),
            Student("Nguyễn Văn O", "789789"),
            Student("Trương Thị P", "321321"),
            Student("Nguyễn Văn Q", "654654"),
            Student("Nguyễn Thị R", "987987"),
            Student("Lê Văn S", "135135"),
            Student("Trần Văn T", "246246"),
        )


        adapter = StudentAdapter(studentList)
        recyclerView.adapter = adapter

        etSearch.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {}

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                filter(s.toString())
            }
        })
    }

    private fun filter(text: String) {
        filteredList = if (text.length > 2) {
            studentList.filter {
                it.name.contains(text, ignoreCase = true) || it.mssv.contains(text, ignoreCase = true)
            }
        } else {
            studentList
        }
        adapter.updateList(filteredList)
    }
}
