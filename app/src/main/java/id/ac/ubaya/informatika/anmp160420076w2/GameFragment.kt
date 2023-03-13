package id.ac.ubaya.informatika.anmp160420076w2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.google.android.material.textfield.TextInputEditText
import kotlinx.android.synthetic.main.fragment_game.*
import kotlin.random.Random

/**
 * A simple [Fragment] subclass.
 * Use the [GameFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class GameFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_game, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if(arguments != null) {
            val playerName =
                GameFragmentArgs.fromBundle(requireArguments()).playerName
            txtTurn.text = "$playerName's Turn"
        }

        /*btnBack.setOnClickListener {
            val action = GameFragmentDirections.actionMainFragment()
            Navigation.findNavController(it).navigate(action)
        }*/

        var randomNum1 = Random.nextInt(0,100)
        var randomNum2 = Random.nextInt(0,100)
        var point = 0
        txtNumber1.text = randomNum1.toString()
        txtNumber2.text = randomNum2.toString()
        var add = randomNum1 + randomNum2

        btnSubmit.setOnClickListener{
            if(txtAnswer.text.toString() == add.toString()) {
                point = point + 1
            } else {
                val action = GameFragmentDirections.actionResultFragment(point)
                Navigation.findNavController(it).navigate(action)
            }
        }
    }
}