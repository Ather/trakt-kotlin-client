package media.thehoard.thirdparty.api.trakt.objects.get.collections

import media.thehoard.thirdparty.api.trakt.objects.basic.implementations.TraktMetadataImpl

interface TraktCollectionShowEpisodeExtendedMetadata : TraktCollectionShowEpisode {
    var metadata: TraktMetadataImpl
}