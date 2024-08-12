package com.example.buynow

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.buynow.DI.ApplicationComponent
import com.example.buynow.ViewModel.MainActivityViewModel
import com.example.buynow.ViewModel.MainActivityViewModelFactory
import jakarta.inject.Inject
import retrofit2.Retrofit

class MainActivity : AppCompatActivity() {
    private lateinit var mainActivityViewModel: MainActivityViewModel

    @Inject
    lateinit var mainActivityViewModelFactory: MainActivityViewModelFactory

    private lateinit var productItem : TextView
    private lateinit var applicationComponent: ApplicationComponent
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        applicationComponent = (application as BuyNowApplication).applicationComponent
        applicationComponent.inject(this)
        val map = applicationComponent.getMap()
        mainActivityViewModel=ViewModelProvider(this,mainActivityViewModelFactory)[MainActivityViewModel::class.java]
        productItem=findViewById(R.id.product_item)
        mainActivityViewModel.productList.observe(this, Observer {
            for(product in it){
                productItem.append("${product.title} \n \n")
            }
        })
    }
}