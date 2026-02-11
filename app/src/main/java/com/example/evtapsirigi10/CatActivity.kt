package com.example.evtapsirigi10

import android.graphics.Color
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.speech.tts.TextToSpeech
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Locale

class CatActivity : AppCompatActivity(), SensorEventListener {

    private  lateinit var sensorManager: SensorManager
    private lateinit var proxSensor: Sensor
    private lateinit var layout: ConstraintLayout
    private lateinit var textToSpeech: TextToSpeech

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_cat)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
      textToSpeech = TextToSpeech(this){status ->
          if (status!= TextToSpeech.ERROR){
              textToSpeech.language = Locale.ENGLISH

          }

      }
        layout = findViewById(R.id.main)
        sensorManager = getSystemService(SENSOR_SERVICE) as SensorManager
        proxSensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY)!!
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
    }

    override fun onSensorChanged(event: SensorEvent?) {
        val value = event?.values?.get(0) ?: 0f

        when(event?.sensor?.type){
            Sensor.TYPE_PROXIMITY ->{
                if (value < (proxSensor.maximumRange)){
                    layout.setBackgroundColor(Color.BLUE)
                    speech("sana alkis yok ancak fingersnap")
                }else{
                    layout.setBackgroundColor(Color.BLACK)
                }
            }
        }
    }
    fun speech(text: String){
        textToSpeech.setPitch(2.0f)
        textToSpeech.speak(text, TextToSpeech.QUEUE_FLUSH,null,null)

    }


    override fun onResume() {
        proxSensor.let {sensorManager
            .registerListener(this,it, SensorManager.SENSOR_DELAY_NORMAL)  }
        super.onResume()
    }
}