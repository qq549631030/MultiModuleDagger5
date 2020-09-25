package cn.hx.user

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.multibindings.IntoSet

@Module
@InstallIn(ActivityComponent::class)
class UserModule {
    @IntoSet
    @Provides
    fun provideString(): String {
        return "user"
    }
}