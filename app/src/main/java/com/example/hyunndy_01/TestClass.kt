package com.example.hyunndy_01

import android.os.Parcel
import android.os.Parcelable

// 1. Parcelable 인터페이스 구현.
class TestClass : Parcelable{

    var data10 : Int = 0
    var data20:String? = null

    // 4.
    // 나중에 data를 복원하는 쪽에서 안드로이드OS는 이 TestClass가 가지고 있는 creater라는 멤버를 갖고 메서드를 호출한다. 이 때 이 Creater 멤버는 Static으로 정의되어 있어야한다.
    // Kotlin에서 상수를 사용할 땐 companion object를 써서 한다.
    companion object
    {
        // 5.
        // Kotlin에서 상수를 정의하는데 이를 안드로이드OS에서 쓸 경우 @JvmField를 붙여줘야한다.
        @JvmField

        // 이 이름은 반드시 CREATOR로 되있어야 한다.
        val CREATOR : Parcelable.Creator<TestClass> =  object : Parcelable.Creator<TestClass>
        {
            // 6. 객체를 복원하는 메서드.
            override fun createFromParcel(source: Parcel?): TestClass {
                val test = TestClass()

                // 객체 읽음
                test.data10 = source?.readInt()!!
                test.data20 = source?.readString()

                // 객체 복원
                return test
            }

            // 7.
            // 객체 하나가아니라 객체들의 배열이 전달되었을 경우..
            // 이 메서드가 먼저 불려서 배열이 만들어지고 각각의 멤버를 복원하기위해서 CreateFromParcel이 호출이 된다.
            override fun newArray(size: Int): Array<TestClass?> {

                // TestClass타입의 배열을 만드는데 그 안에 NULL값을 채워넣는다는것이다.
                return arrayOfNulls<TestClass>(size)
            }
        }
    }

    // 2.
    // 안드로이드에서 객체를 전달할 때는 객체가 전달되는게 아니라 Parcel 클래스 타입이 전달된다.
    // 그래서 전달하고 싶은 데이터들을 Parcel 객체에 넣어주면 뽑아쓸 수 있다.
    override fun writeToParcel(dest: Parcel?, flags: Int) {

        // 3.
        // 데이터를 넣은 순서와 나중에 빼는 순서가 같아야 한다.
        dest?.writeInt(data10)
        dest?.writeString(data20)

    }

    override fun describeContents(): Int {
        return 0
    }
}