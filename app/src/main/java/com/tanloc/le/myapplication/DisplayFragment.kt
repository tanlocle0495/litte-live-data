package com.tanloc.le.myapplication

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.lifecycle.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.displayfragment.*

class DisplayFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.displayfragment, container, false);
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var viewModel = (activity as MainActivity).run {
            ViewModelProviders.of(this).get(MainViewModel::class.java)
        }

        // used for edit live data first display
        var transformedLive = Transformations.map(
            viewModel.data, { "demo $it" }
        )
        var observer = Observer<String> {
            textView.text = it
        }
        transformedLive.observe(viewLifecycleOwner, observer)

        // su dung hai live data co mot thang

        val mediatorLiveData = MediatorLiveData<String>()
        mediatorLiveData.addSource(viewModel.data) {
            mediatorLiveData.value = it
        }
        mediatorLiveData.addSource(viewModel.data2) {
            mediatorLiveData.value = it
        }

        mediatorLiveData.observe(viewLifecycleOwner, Observer {
            textView2?.apply {
                text = it
            }
        });
    }
}