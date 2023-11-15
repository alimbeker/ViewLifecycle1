package com.example.viewlifecycle

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import com.example.viewlifecycle.databinding.ViewToolbarBinding

class ToolbarView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    private val binding: ViewToolbarBinding =
        ViewToolbarBinding.inflate(LayoutInflater.from(context), this)
     init {
         setAttrs(attrs,R.styleable.ToolbarView){
             binding.temp.text = "${it.getInt(R.styleable.ToolbarView_temp,10)}°"
             binding.country.text = it.getString(R.styleable.ToolbarView_country)
             binding.windy.text = if(it.getBoolean(R.styleable.ToolbarView_windy,false)) {
                 "Windy"
             } else {
                 "Sheltered"
             }

             val weatherValue = it.getInt(R.styleable.ToolbarView_fallout, -1)
             val weatherEnum = getWeatherEnumByOrdinal(weatherValue)
             binding.fallout.text = weatherEnum?.displayName ?: "Unknown"


             val daytimeValue = it.getInt(R.styleable.ToolbarView_daytime, -1)
             val daytimeEnum = getDayTimeEnumByOrdinal(daytimeValue)
             daytimeEnum?.imageId?.let {binding.daytime.setImageResource(it) }

         }

         setAttrs(attrs,R.styleable.ToolbarView){
             binding.temp.text = "${it.getInt(R.styleable.ToolbarView_temp,10)}°"
             binding.country.text = it.getString(R.styleable.ToolbarView_country)
             binding.windy.text = if(it.getBoolean(R.styleable.ToolbarView_windy,false)) {
                 "Windy"
             } else {
                 "Sheltered"
             }

             val weatherValue = it.getInt(R.styleable.ToolbarView_fallout, -1)
             val weatherEnum = getWeatherEnumByOrdinal(weatherValue)
             binding.fallout.text = weatherEnum?.displayName ?: "Unknown"



             val daytimeValue = it.getInt(R.styleable.ToolbarView_daytime, -1)
             val daytimeEnum = getDayTimeEnumByOrdinal(daytimeValue)
             daytimeEnum?.imageId?.let { binding.daytime.setImageResource(it) }
         }


         setAttrs(attrs,R.styleable.ToolbarView){
             binding.temp.text = "${it.getInt(R.styleable.ToolbarView_temp,10)}°"
             binding.country.text = it.getString(R.styleable.ToolbarView_country)
             binding.windy.text = if(it.getBoolean(R.styleable.ToolbarView_windy,false)) {
                 "Windy"
             } else {
                 "Sheltered"
             }

             val weatherValue = it.getInt(R.styleable.ToolbarView_fallout, -1)
             val weatherEnum = getWeatherEnumByOrdinal(weatherValue)
             binding.fallout.text = weatherEnum?.displayName ?: "Unknown"



             val daytimeValue = it.getInt(R.styleable.ToolbarView_daytime, -1)
             val daytimeEnum = getDayTimeEnumByOrdinal(daytimeValue)
             daytimeEnum?.imageId?.let { binding.daytime.setImageResource(it) }
         }
     }
}

inline fun View.setAttrs(
    attrs: AttributeSet?,
    styleable: IntArray,
    crossinline body: (TypedArray) -> Unit
) {
    context.theme.obtainStyledAttributes(attrs, styleable, 0, 0)
        .apply {
            try {
                body.invoke(this)
            } finally {
                recycle()
            }
        }
}
enum class Fallout(val displayName: String) {
    WEAK_RAIN("Weak rain"),
    WEAK_SNOW("Weak snow"),
    HEAVY_RAIN("Heavy rain"),
    HEAVY_SNOW("Heavy snow")
}
private fun getWeatherEnumByOrdinal(value: Int): Fallout? {
    return Fallout.values().firstOrNull { it.ordinal == value }
}


enum class DayTime(val imageId: Int) {
    DAY(R.drawable.sun), NIGHT(R.drawable.moon_cloud)
}

private fun getDayTimeEnumByOrdinal(value: Int): DayTime? {
    return DayTime.values().firstOrNull { it.ordinal == value }
}
