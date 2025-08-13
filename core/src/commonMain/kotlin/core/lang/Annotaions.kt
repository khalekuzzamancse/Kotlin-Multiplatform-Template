package core.lang

@RequiresOptIn(message = "Use this only within the data layer and the di layer(if required)")
@Retention(AnnotationRetention.BINARY)
annotation class DataLayerMember
@RequiresOptIn(message = "Use this only within the presentation layer and the di layer(if required)")
@Retention(AnnotationRetention.BINARY)
annotation class PresentationLayerMember