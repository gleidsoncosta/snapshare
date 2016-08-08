package com.example.mourao.photoshare;

import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button tirarFotos = (Button) findViewById(R.id.tirarFotoButton);
        Button verFotos = (Button) findViewById(R.id.verFotosButton);
        Button compartilhar = (Button) findViewById(R.id.compartilharButton);

        tirarFotos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                String foto = Environment.DIRECTORY_DCIM + "/" + System.currentTimeMillis() + ".jpg";

                File arquivo = new File(foto);

                Uri outputFileUri = Uri.fromFile(arquivo);

                cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, outputFileUri);

                startActivity(cameraIntent);

            }
        });

    }
}
