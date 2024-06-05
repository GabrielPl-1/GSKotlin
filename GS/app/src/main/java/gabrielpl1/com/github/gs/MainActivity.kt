package gabrielpl1.com.github.gs

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.recyclerview.widget.RecyclerView
import gabrielpl1.com.github.gs.adapter.ItemsAdapter
import gabrielpl1.com.github.gs.viewmodel.ItemsViewModel

class MainActivity : ComponentActivity() {
    val viewModel: ItemsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView1)
        val itemsAdapter = ItemsAdapter()
        recyclerView.adapter = itemsAdapter

        val button = findViewById<Button>(R.id.button)
        val editText = findViewById<EditText>(R.id.Praia)
        val editText2 = findViewById<EditText>(R.id.Cidade)
        val editText3 = findViewById<EditText>(R.id.Estado)

        button.setOnClickListener {
            val text1 = editText.text.toString()
            val text2 = editText2.text.toString()
            val text3 = editText3.text.toString()

            if (text1.isEmpty()) {
                editText.error = "Preencha um valor"
                return@setOnClickListener
            }

            if (text2.isEmpty()) {
                editText2.error = "Preencha um valor"
                return@setOnClickListener
            }

            if (text3.isEmpty()) {
                editText3.error = "Preencha um valor"
                return@setOnClickListener
            }

            val combinedText = "$text1 $text2 $text3"
            viewModel.addItem(combinedText)

            editText.text.clear()
            editText2.text.clear()
            editText3.text.clear()
        }

        viewModel.itemsLiveData.observe(this) { items ->
            itemsAdapter.updateItems(items)
        }
    }
}