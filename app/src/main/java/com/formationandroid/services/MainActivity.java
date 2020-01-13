package com.formationandroid.services;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity
{
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// init :
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// démarrage service
		Intent intentService = new Intent(this, CompteurService.class);
		startService(intentService);
	}
	
	/**
	 * Listener clic bouton compteur.
	 * @param view Bouton
	 */
	public void onClickCompteur(View view)
	{
		Intent intent = new Intent(this, CompteurIntentService.class);
		startService(intent);
	}
	
	/**
	 * Listener clic bouton page secondaire.
	 * @param view Bouton
	 */
	public void onClickPageSecondaire(View view)
	{
		Intent intent = new Intent(this, DetailActivity.class);
		startActivity(intent);
	}
	
}
