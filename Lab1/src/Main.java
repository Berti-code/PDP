import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        Product spoon = new Product("spoon", 5);
        Product fork = new Product("fork", 45);
        Product plate = new Product("plate", 13);
        Product eggs = new Product("eggs", 15);
        Product flour = new Product("flour", 9);
        Product sugar = new Product("sugar", 10);

        inventory.add(spoon, 10);
        inventory.add(fork, 4);
        inventory.add(plate, 3);
        inventory.add(eggs, 6);
        inventory.add(flour, 1);
        inventory.add(sugar, 8);

        List<Bill> salesRecord = new ArrayList<>();
        float money = 0;

        Bill bill1 = new Bill();
        Transaction transaction1 = new Transaction(inventory, "transaction1", bill1);
        transaction1.add(spoon, 5);
        transaction1.add(fork, 1);
        salesRecord.add(bill1);
        money += bill1.getTotalPrice();

        Bill bill2 = new Bill();
        Transaction transaction2 = new Transaction(inventory, "transaction2", bill2);
        transaction2.add(flour, 1);
        transaction2.add(eggs, 1);
        transaction2.add(sugar, 2);
        salesRecord.add(bill2);
        money += bill2.getTotalPrice();

        Bill bill3 = new Bill();
        Transaction transaction3 = new Transaction(inventory, "transaction3", bill3);
        transaction3.add(plate, 2);
        transaction3.add(fork, 2);
        transaction3.add(spoon, 5);
        salesRecord.add(bill3);
        money += bill3.getTotalPrice();

        List<Thread> threads = new ArrayList<>();

        threads.add(new Thread(transaction1));
        threads.add(new Thread(transaction2));
        threads.add(new Thread(transaction3));

        for (Thread thread : threads){
            thread.start();
        }

        for (Thread thread : threads){
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("\nInventory:");
        System.out.println(inventory);

        System.out.println("RecordOfBills:");
        for (var record : salesRecord){
            System.out.println(record);
        }

        inventoryCheck(salesRecord, money);
    }

    private static void inventoryCheck(List<Bill> salesRecord, float money){
        float salesRevenue = 0;
        for (var bill : salesRecord){
            salesRevenue += bill.getTotalPrice();
        }
        if (salesRevenue == money){
            System.out.println("Sales revenue checks out!");
        } else {
            System.out.println("Sales revenue doesn't check out!");
        }
    }
}