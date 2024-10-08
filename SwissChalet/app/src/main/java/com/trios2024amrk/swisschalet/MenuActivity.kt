package com.trios2024amrk.swisschalet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import androidx.preference.Preference
import androidx.preference.PreferenceManager
import com.trios2024amrk.swisschalet.databinding.ActivityMenuBinding
import com.trios2024amrk.swisschalet.ui.main.MainViewModel
import com.trios2024amrk.swisschalet.ui.main.MainViewModelFactory
import com.trios2024amrk.swisschalet.ui.main.MenuFragment

class MenuActivity : AppCompatActivity()
{

    private lateinit var binding: ActivityMenuBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this, MainViewModelFactory(PreferenceManager.
        getDefaultSharedPreferences(this))
        ).get(MainViewModel::class.java)

        binding = ActivityMenuBinding.inflate(layoutInflater)
        
        val view = binding.root
        setContentView(view)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MenuFragment.newInstance())
                .commitNow()
        }
         binding.fabButton.setOnClickListener {
             showCreateListDialog()
         }
    }
    private fun showCreateListDialog()
    {

        val dialogTitle = getString(R.string.name_of_list)
        val positiveButtonTitle = getString(R.string.create_list)
        val builder = AlertDialog.Builder(this)
        val listTitleEditText = EditText(this)

        listTitleEditText.inputType = InputType.TYPE_CLASS_TEXT

        builder.setTitle(dialogTitle)
        builder.setView(listTitleEditText)

        builder.setPositiveButton(positiveButtonTitle)
        { dialog, _ ->
            dialog.dismiss()
            viewModel.saveList(TaskList(listTitleEditText.text.toString()))
        }

        builder.create().show()
    }

}