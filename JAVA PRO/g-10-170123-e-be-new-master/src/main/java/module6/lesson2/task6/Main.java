package module6.lesson2.task6;

public class Main {

    /*
1. Написать класс Банковский аккаунт.
2. Аккаунт должен содержать переменную с остатком денег.
3. Должно быть можно установить остаток денег, узнать остаток и снять определённую сумму.
4. Написать класс Клиент. Клиент должен уметь работать в отдельном потоке.
5. У клиента должно быть имя и банковский аккаунт (задаются при создании объекта).
6. В отдельном потоке клиент должен выполнять следующие действия:
	а. Определить, сколько денег он хочет снять (пусть будет 1000).
	б. Вывести информацию о том, что клиент подошёл к банкомату (с именем).
	в. Получить и записать в переменную, сколько денег на счёте.
	г. Подождать 3 секунды.
	д. Проверить, достаточно ли денег на счёте, чтобы снять желаемую сумму.
		Если да - снять сумму и вывести об этом информацию в консоль.
		Если нет - вывести в консоль информацию, что денег недостаточно.
7. Создать объект аккаунта.
8. Зачислить на аккаунт сумму 1500.
9. Создать двух клиентов с разными именами, но одним и тем же аккаунтом.
10. Запустить клиентов в последовательном однопоточном режиме.
11. После того, как оба клиента отработают, вывести в консоль оставшуюся сумму на аккаунте.
12. Запустить клиентов в многопоточном режиме (не забывая, что главный поток должен
    дождаться завершения потоков прежде чем выводить информацию об остатке денег в консоль).
*/

    public static void main(String[] args) {
        BankAccount account = new BankAccount();
        account.setRestMoney(1500);
        Client client1 = new Client(account, "Вася");
        Client client2 = new Client(account, "Игорь");
//        client1.run();
//        client2.run();

        client1.start();
        client2.start();
        try {
            client1.join();
            client2.join();
        } catch (InterruptedException ignored) {
        }
        System.out.printf("Rest money %d", account.getRestMoney());
    }
}