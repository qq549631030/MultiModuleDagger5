package cn.hx.user

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.multibindings.IntoSet

@Module
@InstallIn(ViewModelComponent::class)
class UserModule {
    @IntoSet
    @Provides
    fun provideString(): String {
        return "user"
    }
}