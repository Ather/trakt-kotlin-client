package media.thehoard.thirdparty.api.trakt.responses

import media.thehoard.thirdparty.api.trakt.responses.interfaces.ITraktListResponse
import kotlin.reflect.KClass

open class TraktListResponse<TResponseContentType>(responseContentClass: KClass<*>) : TraktResponse<MutableList<TResponseContentType>>(responseContentClass), ITraktListResponse<TResponseContentType> {
    override val size: Int
        get() = value!!.size

    override fun add(element: TResponseContentType): Boolean = value!!.add(element)

    override fun add(index: Int, element: TResponseContentType) = value!!.add(index, element)

    override fun addAll(index: Int, elements: Collection<TResponseContentType>): Boolean = value!!.addAll(index, elements)

    override fun addAll(elements: Collection<TResponseContentType>): Boolean = value!!.addAll(elements)

    override fun clear() = value!!.clear()

    override fun contains(element: TResponseContentType): Boolean = value!!.contains(element)

    override fun containsAll(elements: Collection<TResponseContentType>): Boolean = value!!.containsAll(elements)

    override fun get(index: Int): TResponseContentType = value!![index]

    override fun indexOf(element: TResponseContentType): Int = value!!.indexOf(element)

    override fun isEmpty(): Boolean = value!!.isEmpty()

    override fun iterator(): MutableIterator<TResponseContentType> = value!!.iterator()

    override fun lastIndexOf(element: TResponseContentType): Int = value!!.lastIndexOf(element)

    override fun listIterator(): MutableListIterator<TResponseContentType> = value!!.listIterator()

    override fun listIterator(index: Int): MutableListIterator<TResponseContentType> = value!!.listIterator(index)

    override fun remove(element: TResponseContentType): Boolean = value!!.remove(element)

    override fun removeAll(elements: Collection<TResponseContentType>): Boolean = value!!.removeAll(elements)

    override fun removeAt(index: Int): TResponseContentType = value!!.removeAt(index)

    override fun retainAll(elements: Collection<TResponseContentType>): Boolean = value!!.retainAll(elements)

    override fun set(index: Int, element: TResponseContentType): TResponseContentType = value!!.set(index, element)

    override fun subList(fromIndex: Int, toIndex: Int): MutableList<TResponseContentType> = value!!.subList(fromIndex, toIndex)

    override fun equals(other: Any?): Boolean {
        if (other is TraktListResponse<*>)
            return super.equals(other)

        return false
    }

}
