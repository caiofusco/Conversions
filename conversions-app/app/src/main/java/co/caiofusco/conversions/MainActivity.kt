package co.caiofusco.conversions

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.PopupMenu
import co.caiofusco.conversions.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private var menuType = R.menu.menu_conversion_type_length

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonConversionType1.setOnClickListener(this)
        binding.buttonConversionType2.setOnClickListener(this)
        binding.buttonCalculate.setOnClickListener(this)
        binding.buttonLength.setOnClickListener(this)
        binding.buttonWeight.setOnClickListener(this)
        binding.buttonTemperature.setOnClickListener(this)
        binding.buttonVolume.setOnClickListener(this)
    }

    override fun onClick(view: View) {

        buttonConversionTypeOnClick(view)
        buttonMeasurementUnitsOnClick(view)
        buttonCalculateOnClick(view)

    }

    private fun buttonConversionTypeOnClick(view: View) {
        if (view.id == R.id.button_conversion_type_1) {
            val menu = PopupMenu(this, binding.buttonConversionType1)
            val buttonType = 1
            menuInflateConversionType(menu, menuType, buttonType)

        }
        if (view.id == R.id.button_conversion_type_2) {
            val menu = PopupMenu(this, binding.buttonConversionType2)
            val buttonType = 2
            menuInflateConversionType(menu, menuType, buttonType)
        }
    }

    private fun buttonMeasurementUnitsOnClick(view: View) {
        if (view.id == R.id.button_length) {
            val conversionType = R.id.button_length
            changeConversionType(conversionType)
        }

        if (view.id == R.id.button_weight) {
            val conversionType = R.id.button_weight
            changeConversionType(conversionType)
        }

        if (view.id == R.id.button_temperature) {
            val conversionType = R.id.button_temperature
            changeConversionType(conversionType)
        }

        if (view.id == R.id.button_volume) {
            val conversionType = R.id.button_volume
            changeConversionType(conversionType)
        }
    }

    private fun buttonCalculateOnClick(view: View) {
        if (view.id == R.id.button_calculate) {
            if (binding.editEnterTheValue.text.isNotBlank()) {
                val value = binding.editEnterTheValue.text.toString().toDouble()
                when (menuType) {
                    R.menu.menu_conversion_type_length -> {
                        binding.textResult.text = calculateLength(value).toString()
                    }

                    R.menu.menu_conversion_type_weight -> {
                        binding.textResult.text = calculateWeight(value).toString()
                    }

                    R.menu.menu_conversion_type_temperature -> {
                        binding.textResult.text = calculateTemperature(value).toString()
                    }

                    R.menu.menu_conversion_type_volume -> {
                        binding.textResult.text = calculateVolume(value).toString()
                    }
                }
            }
        }
    }

    private fun changeConversionType(conversionType: Int) {
        when (conversionType) {
            R.id.button_length -> {

                menuType = R.menu.menu_conversion_type_length

                binding.buttonConversionType1.text = getString(R.string.km)
                binding.buttonConversionType2.text = getString(R.string.m)

            }

            R.id.button_weight -> {

                menuType = R.menu.menu_conversion_type_weight

                binding.buttonConversionType1.text = getString(R.string.kg)
                binding.buttonConversionType2.text = getString(R.string.g)

            }

            R.id.button_temperature -> {
                menuType = R.menu.menu_conversion_type_temperature

                binding.buttonConversionType1.text = getString(R.string.c)
                binding.buttonConversionType2.text = getString(R.string.f)

            }

            R.id.button_volume -> {
                menuType = R.menu.menu_conversion_type_volume

                binding.buttonConversionType1.text = getString(R.string.km_volume)
                binding.buttonConversionType2.text = getString(R.string.m_volume)

            }
        }
    }

    private fun menuInflateConversionType(menu: PopupMenu, menuType: Int, buttonType: Int) {

        menu.apply {
            menuInflater.inflate(menuType, this.menu)
            setOnMenuItemClickListener {
                getMenuItem(it.itemId, it.title, buttonType)
                true
            }
            show()
        }
    }

    private fun getMenuItem(itemId: Int, title: CharSequence?, buttonType: Int) {
        if (itemId == R.id.item_1) {
            if (buttonType == 1) {
                binding.buttonConversionType1.text = title
            } else {
                binding.buttonConversionType2.text = title
            }

        }
        if (itemId == R.id.item_2) {
            if (buttonType == 1) {
                binding.buttonConversionType1.text = title
            } else {
                binding.buttonConversionType2.text = title
            }

        }
        if (itemId == R.id.item_3) {
            if (buttonType == 1) {
                binding.buttonConversionType1.text = title
            } else {
                binding.buttonConversionType2.text = title
            }
        }
        if (itemId == R.id.item_4) {
            if (buttonType == 1) {
                binding.buttonConversionType1.text = title
            } else {
                binding.buttonConversionType2.text = title
            }
        }
        if (itemId == R.id.item_5) {
            if (buttonType == 1) {
                binding.buttonConversionType1.text = title
            } else {
                binding.buttonConversionType2.text = title
            }
        }
        if (itemId == R.id.item_6) {
            if (buttonType == 1) {
                binding.buttonConversionType1.text = title
            } else {
                binding.buttonConversionType2.text = title
            }
        }

        if (itemId == R.id.item_7) {
            if (buttonType == 1) {
                binding.buttonConversionType1.text = title
            } else {
                binding.buttonConversionType2.text = title
            }
        }
    }

    private fun calculateLength(value: Double): Double {
        val km = getString(R.string.km)
        val hm = getString(R.string.hm)
        val dam = getString(R.string.dam)
        val m = getString(R.string.m)
        val dm = getString(R.string.dm)
        val cm = getString(R.string.cm)
        val mm = getString(R.string.mm)

        if (binding.buttonConversionType1.text == km) {
            when (binding.buttonConversionType2.text) {
                hm -> {
                    return value * 10
                }

                dam -> {
                    return value * 100
                }

                m -> {
                    return value * 1000
                }

                dm -> {
                    return value * 10000
                }

                cm -> {
                    return value * 100000
                }

                mm -> {
                    return value * 1000000
                }
            }
        }

        if (binding.buttonConversionType1.text == hm) {
            when (binding.buttonConversionType2.text) {
                km -> {
                    return value / 10
                }

                dam -> {
                    return value * 10
                }

                m -> {
                    return value * 100
                }

                dm -> {
                    return value * 1000
                }

                cm -> {
                    return value * 10000
                }

                mm -> {
                    return value * 100000
                }
            }
        }

        if (binding.buttonConversionType1.text == dam) {
            when (binding.buttonConversionType2.text) {
                km -> {
                    return value / 100
                }

                hm -> {
                    return value / 10
                }

                m -> {
                    return value * 10
                }

                dm -> {
                    return value * 100
                }

                cm -> {
                    return value * 1000
                }

                mm -> {
                    return value * 10000
                }
            }
        }

        if (binding.buttonConversionType1.text == m) {
            when (binding.buttonConversionType2.text) {
                km -> {
                    return value / 1000
                }

                hm -> {
                    return value / 100
                }

                dam -> {
                    return value / 10
                }

                dm -> {
                    return value * 10
                }

                cm -> {
                    return value * 100
                }

                mm -> {
                    return value * 1000
                }
            }
        }

        if (binding.buttonConversionType1.text == dm) {
            when (binding.buttonConversionType2.text) {
                km -> {
                    return value / 10000
                }

                hm -> {
                    return value / 1000
                }

                dam -> {
                    return value / 100
                }

                m -> {
                    return value / 10
                }

                cm -> {
                    return value * 10
                }

                mm -> {
                    return value * 100
                }
            }
        }

        if (binding.buttonConversionType1.text == cm) {
            when (binding.buttonConversionType2.text) {
                km -> {
                    return value / 100000
                }

                hm -> {
                    return value / 10000
                }

                dam -> {
                    return value / 1000
                }

                m -> {
                    return value / 100
                }

                dm -> {
                    return value / 10
                }

                mm -> {
                    return value * 10
                }
            }
        }

        if (binding.buttonConversionType1.text == mm) {
            when (binding.buttonConversionType2.text) {
                km -> {
                    return value / 1000000
                }

                hm -> {
                    return value / 100000
                }

                dam -> {
                    return value / 10000
                }

                m -> {
                    return value / 1000
                }

                dm -> {
                    return value / 100
                }

                cm -> {
                    return value / 10
                }
            }
        }

        return value
    }

    private fun calculateWeight(value: Double): Double {
        val kg = getString(R.string.kg)
        val hg = getString(R.string.hg)
        val dag = getString(R.string.dag)
        val g = getString(R.string.g)
        val dg = getString(R.string.dg)
        val cg = getString(R.string.cg)
        val mg = getString(R.string.mg)

        if (binding.buttonConversionType1.text == kg) {
            when (binding.buttonConversionType2.text) {
                hg -> {
                    return value * 10
                }

                dag -> {
                    return value * 100
                }

                g -> {
                    return value * 1000
                }

                dg -> {
                    return value * 10000
                }

                cg -> {
                    return value * 100000
                }

                mg -> {
                    return value * 1000000
                }
            }
        }

        if (binding.buttonConversionType1.text == hg) {
            when (binding.buttonConversionType2.text) {
                kg -> {
                    return value / 10
                }

                dag -> {
                    return value * 10
                }

                g -> {
                    return value * 100
                }

                dg -> {
                    return value * 1000
                }

                cg -> {
                    return value * 10000
                }

                mg -> {
                    return value * 100000
                }
            }
        }

        if (binding.buttonConversionType1.text == dag) {
            when (binding.buttonConversionType2.text) {
                kg -> {
                    return value / 100
                }

                hg -> {
                    return value / 10
                }

                g -> {
                    return value * 10
                }

                dg -> {
                    return value * 100
                }

                cg -> {
                    return value * 1000
                }

                mg -> {
                    return value * 10000
                }
            }
        }

        if (binding.buttonConversionType1.text == g) {
            when (binding.buttonConversionType2.text) {
                kg -> {
                    return value / 1000
                }

                hg -> {
                    return value / 100
                }

                dag -> {
                    return value / 10
                }

                dg -> {
                    return value * 10
                }

                cg -> {
                    return value * 100
                }

                mg -> {
                    return value * 1000
                }
            }
        }

        if (binding.buttonConversionType1.text == dg) {
            when (binding.buttonConversionType2.text) {
                kg -> {
                    return value / 10000
                }

                hg -> {
                    return value / 1000
                }

                dag -> {
                    return value / 100
                }

                g -> {
                    return value / 10
                }

                cg -> {
                    return value * 10
                }

                mg -> {
                    return value * 100
                }
            }
        }

        if (binding.buttonConversionType1.text == cg) {
            when (binding.buttonConversionType2.text) {
                kg -> {
                    return value / 100000
                }

                hg -> {
                    return value / 10000
                }

                dag -> {
                    return value / 1000
                }

                g -> {
                    return value / 100
                }

                dg -> {
                    return value / 10
                }

                mg -> {
                    return value * 10
                }
            }
        }

        if (binding.buttonConversionType1.text == mg) {
            when (binding.buttonConversionType2.text) {
                kg -> {
                    return value / 1000000
                }

                hg -> {
                    return value / 100000
                }

                dag -> {
                    return value / 10000
                }

                g -> {
                    return value / 1000
                }

                dg -> {
                    return value / 100
                }

                cg -> {
                    return value / 10
                }
            }
        }

        return value
    }

    private fun calculateTemperature(value: Double): Double {
        val c = getString(R.string.c)
        val f = getString(R.string.f)
        val k = getString(R.string.k)

        if (binding.buttonConversionType1.text == c) {
            when (binding.buttonConversionType2.text) {
                f -> {
                    return ((value * 1.8) + 32)
                }

                k -> {
                    return value + 273.15
                }
            }
        }

        if (binding.buttonConversionType1.text == f) {
            when (binding.buttonConversionType2.text) {
                c -> {
                    return (value - 32) / 1.8
                }

                k -> {
                    return ((value - 32) * 5 / 9) + 273.15
                }
            }
        }

        if (binding.buttonConversionType1.text == k) {
            when (binding.buttonConversionType2.text) {
                c -> {
                    return value - 273.15
                }

                f -> {
                    return (value - 273.15) * 1.8 + 32
                }
            }
        }

        return value

    }

    private fun calculateVolume(value: Double): Double {
        val kmVolume = getString(R.string.km_volume)
        val hmVolume = getString(R.string.hm_volume)
        val damVolume = getString(R.string.dam_volume)
        val mVolume = getString(R.string.m_volume)
        val dmVolume = getString(R.string.dm_volume)
        val cmVolume = getString(R.string.cm_volume)
        val mmVolume = getString(R.string.mm_volume)

        if (binding.buttonConversionType1.text == kmVolume) {
            when (binding.buttonConversionType2.text) {
                hmVolume -> {
                    return value * 1000
                }

                damVolume -> {
                    return value * 1000000
                }

                mVolume -> {
                    return value * 1000000000
                }

                dmVolume -> {
                    return value * 1000000000000
                }

                cmVolume -> {
                    return value * 1000000000000000
                }

                mmVolume -> {
                    return value * 1000000000000000000
                }
            }
        }

        if (binding.buttonConversionType1.text == hmVolume) {
            when (binding.buttonConversionType2.text) {
                kmVolume -> {
                    return value / 1000
                }

                damVolume -> {
                    return value * 1000
                }

                mVolume -> {
                    return value * 1000000
                }

                dmVolume -> {
                    return value * 1000000000
                }

                cmVolume -> {
                    return value * 1000000000000
                }

                mmVolume -> {
                    return value * 1000000000000000
                }
            }
        }

        if (binding.buttonConversionType1.text == damVolume) {
            when (binding.buttonConversionType2.text) {
                kmVolume -> {
                    return value / 1000000
                }

                hmVolume -> {
                    return value / 1000
                }

                mVolume -> {
                    return value * 1000
                }

                dmVolume -> {
                    return value * 1000000
                }

                cmVolume -> {
                    return value * 1000000000
                }

                mmVolume -> {
                    return value * 1000000000000
                }
            }
        }

        if (binding.buttonConversionType1.text == mVolume) {
            when (binding.buttonConversionType2.text) {
                kmVolume -> {
                    return value / 1000000000
                }

                hmVolume -> {
                    return value / 1000000
                }

                damVolume -> {
                    return value / 1000
                }

                dmVolume -> {
                    return value * 1000
                }

                cmVolume -> {
                    return value * 1000000
                }

                mmVolume -> {
                    return value * 1000000000
                }
            }
        }

        if (binding.buttonConversionType1.text == dmVolume) {
            when (binding.buttonConversionType2.text) {
                kmVolume -> {
                    return value / 1000000000000
                }

                hmVolume -> {
                    return value / 1000000000
                }

                damVolume -> {
                    return value / 1000000
                }

                mVolume -> {
                    return value / 1000
                }

                cmVolume -> {
                    return value * 1000
                }

                mmVolume -> {
                    return value * 1000000
                }
            }
        }

        if (binding.buttonConversionType1.text == cmVolume) {
            when (binding.buttonConversionType2.text) {
                kmVolume -> {
                    return value / 1000000000000000
                }

                hmVolume -> {
                    return value / 1000000000000
                }

                damVolume -> {
                    return value / 1000000000
                }

                mVolume -> {
                    return value / 1000000
                }

                dmVolume -> {
                    return value / 1000
                }

                mmVolume -> {
                    return value * 1000
                }
            }
        }

        if (binding.buttonConversionType1.text == mmVolume) {
            when (binding.buttonConversionType2.text) {
                kmVolume -> {
                    return value / 1000000000000000000
                }

                hmVolume -> {
                    return value / 1000000000000000
                }

                damVolume -> {
                    return value / 1000000000000
                }

                mVolume -> {
                    return value / 1000000000
                }

                dmVolume -> {
                    return value / 1000000
                }

                cmVolume -> {
                    return value / 1000
                }
            }
        }

        return value

    }

}