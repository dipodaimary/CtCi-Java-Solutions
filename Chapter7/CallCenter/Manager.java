package Chapter7.CallCenter;

class Manager extends Employee {
    public Manager(CallHandler callHandler) {
        super(callHandler);
        rank = Rank.Manager;
    }
}