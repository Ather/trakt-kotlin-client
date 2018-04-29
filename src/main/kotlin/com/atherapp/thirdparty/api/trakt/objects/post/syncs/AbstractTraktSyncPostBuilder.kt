package com.atherapp.thirdparty.api.trakt.objects.post.syncs

abstract class AbstractTraktSyncPostBuilder<BuildResult, BuilderReturn : AbstractTraktSyncPostBuilder<BuildResult, BuilderReturn>> {
    abstract fun reset()

    abstract fun build(): BuildResult

    protected abstract fun self(): BuilderReturn
}
