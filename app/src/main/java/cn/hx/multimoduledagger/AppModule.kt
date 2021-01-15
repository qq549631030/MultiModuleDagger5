package cn.hx.multimoduledagger

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoSet

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @IntoSet
    @Provides
    fun provideString(): String {
        return "app"
    }
}