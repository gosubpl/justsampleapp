package pac

trait Hashable {
  protected def hash(key: String) = key.hashCode.abs
}
