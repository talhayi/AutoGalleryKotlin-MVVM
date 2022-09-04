package com.example.autogallerykotlin.data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


class UserPreferences(
    private val context: Context
) {
    /*
        private val applicationContext = context.applicationContext
        private val dataStore : DataStore<Preferences>


     */
    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "my_data_store")


    val authToken: Flow<String?>
        get() = context.dataStore.data.map { preferences ->
            preferences[KEY_AUTH]
        }

    suspend fun saveAuthToken(authToken: String) {
        context.dataStore.edit { preferences ->
            preferences[KEY_AUTH] = authToken
        }
    }

    companion object {
        private val KEY_AUTH = stringPreferencesKey("key_auth")
    }

}