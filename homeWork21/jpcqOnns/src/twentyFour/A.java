package twentyFour;

class A {
    class B {

    }
}

class C extends A.B {
    public C() {
        //Вызов конструктора суперкласса через экземпляр внешнего класса

        new A().super();
    }
}
