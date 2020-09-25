package cn.hx.news

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.multibindings.IntoSet

@Module
@InstallIn(ActivityComponent::class)
class NewsModule {

    @IntoSet
    @Provides
    fun provideString(): String {
        return "news"
    }
}