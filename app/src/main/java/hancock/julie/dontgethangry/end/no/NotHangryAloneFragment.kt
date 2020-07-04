package hancock.julie.dontgethangry.end.no

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import hancock.julie.dontgethangry.R
import hancock.julie.dontgethangry.end.EndActivity
import hancock.julie.dontgethangry.end.EndPresentation
import kotlinx.android.synthetic.main.fragment_not_hangry_alone.*

class NotHangryAloneFragment : Fragment(){

    private lateinit var gridLayoutManager: GridLayoutManager
    private lateinit var presentation: EndPresentation

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_not_hangry_alone, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presentation = (activity as EndActivity).presentation
        gridLayoutManager = GridLayoutManager(requireContext(),3)
        rv.layoutManager = gridLayoutManager
        rv.adapter = EndAdapter(
            presentation.getOverlapping(),
            requireContext()
        )
    }
}