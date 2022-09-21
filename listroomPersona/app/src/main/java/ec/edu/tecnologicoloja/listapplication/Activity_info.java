package ec.edu.tecnologicoloja.listapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import ec.edu.tecnologicoloja.listapplication.database.Persona;

public class Activity_info extends AppCompatActivity {

    private Persona objeto;
    private TextView nombre,apellido,direccion;
    private ImageView imagen,imagenDato;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);



        //creamos el objeto de tipo persona
        objeto = (Persona) getIntent().getSerializableExtra("id");

        //inicializamos los texView para mostrar los datos
        nombre = findViewById(R.id.txtnombre);
        apellido = findViewById(R.id.txtapellido);
        direccion = findViewById(R.id.txtdireccion);
        imagen = findViewById(R.id.img);
        imagenDato= findViewById(R.id.imgdato);

        //para agregar otro dato con la imagen
        imagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity_info.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });


        //llamamos a los atributos de tipo objeto
        nombre.setText(objeto.getNombre());
        apellido.setText(objeto.getApellido());
        direccion.setText(objeto.getDireccion());

        //llamamos a la imagen del dato
        Glide.with(this).load("http://i.imgur.com/DvpvklR.png").into(imagenDato);







    }
}