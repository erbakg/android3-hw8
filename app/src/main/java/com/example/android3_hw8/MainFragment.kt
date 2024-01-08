package com.example.android3_hw8

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android3_hw8.databinding.FragmentMainBinding
import retrofit2.Call
import retrofit2.Response

class MainFragment : Fragment() {
    private lateinit var charactersList: List<Character>
    private lateinit var adapter: CharactersListAdapter
    private lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadData()
    }

    private fun loadData() {
        val call = ApiClient.apiService.getCharacters()
        call.enqueue(object : retrofit2.Callback<ResponseData> {
            override fun onResponse(
                call: Call<ResponseData>,
                response: Response<ResponseData>
            ) {
                if (response.isSuccessful) {
                    charactersList = (response.body()?.results ?: null)!!
                    adapter = response.body()?.results?.let { CharactersListAdapter(it, ::onClick) }!!
                    binding.rvCharactersList.layoutManager = LinearLayoutManager(context)
                    binding.rvCharactersList.adapter = adapter
                }

            }
            override fun onFailure(call: Call<ResponseData>, t: Throwable) {
                Toast.makeText(context, t.message, Toast.LENGTH_LONG).show()
            }

        })
    }
    private fun onClick(character: Character){
        findNavController().navigate(R.id.detailsFragment, bundleOf(CONSTANTS.CHARACTER to character))
    }
}