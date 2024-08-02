package GUI;

import java.awt.*;
import javax.swing.*;

public class CoffeeShop extends JFrame {
    private static final String[] items = { "Americano ", "Latte     ", "Cappuccino", "Espresso  ", "Arabica   ",
            "Mochaccino", "Tiramisu  ", "Robusta   ", "Liberica  ", "Excelso   ", "Affogato  " };
    private static final int[] prices = { 21, 24, 29, 19, 23, 33, 33, 30, 66, 95, 34 };
    private static final int[] orders = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
    static double cost, finalCost;
    static boolean isDiscount;
    static JLabel lRawCost, lIsDiscount, lFinalCost;
    JLabel[] tfCount;
    static String discount;

    CoffeeShop() {
        final Font westButtonFont = new Font("Georgia", Font.PLAIN, 20);
        JPanel pCF = new JPanel();
        cost = 0;
        isDiscount = false;
        pCF.setLayout(new BorderLayout(20, 15));

        /* ******************************* NORTH ******************************** */
        JLabel lWelcome = new JLabel("*If your purchase reach Rp.100K, you will get a 15% discount!");
        lWelcome.setFont(new Font("MS Serif", Font.BOLD, 14));
        JPanel pNorth = new JPanel();
        pNorth.add(lWelcome);
        pCF.add(pNorth, BorderLayout.NORTH);

        /* ******************************** WEST ******************************** */
        JButton bPurchase = new JButton("Purchase");
        bPurchase.setFont(westButtonFont);
        bPurchase.addActionListener(e -> {
            update();
            boolean orderListIsEmpty = true;
            for (int i = 0; i < items.length; i++) {
                if (orders[i] != 0) {
                    orderListIsEmpty = false;
                    break;
                }
            }
            if (!orderListIsEmpty) {new Transaction();}
            reset();
        });
        JButton bReset = new JButton("Reset");
        bReset.setFont(westButtonFont);
        bReset.addActionListener(e -> reset());
        JPanel pWest = new JPanel();
        pWest.add(bPurchase);
        pWest.add(bReset);
        pWest.setLayout(new GridLayout(2, 1));
        pCF.add(pWest, BorderLayout.WEST);

        /* ******************************* CENTER ******************************* */
        JLabel lItem;
        JLabel lPrice;
        JLabel lItemList = new JLabel("Menu:");
        JLabel lPriceList = new JLabel("Price:");
        JPanel pCenter = new JPanel();
        pCenter.add(lItemList);
        pCenter.add(lPriceList);
        for (int i = 0; i < items.length; i++) {
            lItem = new JLabel(items[i]);
            pCenter.add(lItem);
            lPrice = new JLabel("(" + prices[i] + "K)");
            pCenter.add(lPrice);
        }
        pCenter.setLayout(new GridLayout((items.length + 1), 2, 30, 0));
        pCF.add(pCenter, BorderLayout.CENTER);

        /* ******************************** EAST ******************************** */
        JPanel pEast = new JPanel();
        JLabel lOrder = new JLabel("Orders:");
        pEast.add(lOrder);
        JLabel lReduceButtons = new JLabel("");
        pEast.add(lReduceButtons);
        JLabel lIncreaseButtons = new JLabel("");
        pEast.add(lIncreaseButtons);
        tfCount = new JLabel[items.length];
        JButton[] bReduce = new JButton[items.length];
        JButton[] bIncrease = new JButton[items.length];
        for (int i = 0; i < tfCount.length; i++) {
            final int id = i;
            tfCount[i] = new JLabel("0");
            pEast.add(tfCount[i]);
            bReduce[i] = new JButton("-");
            bReduce[i].addActionListener(k -> {
                tfCount[id].setText(Integer.toString(Integer.parseInt(tfCount[id].getText()) - 1));
                orders[id]--;
                if (Integer.parseInt(tfCount[id].getText()) < 0) {
                    tfCount[id].setText("0");
                    orders[id] = 0;
                }
                update();
            });
            pEast.add(bReduce[i]);
            bIncrease[i] = new JButton("+");
            bIncrease[i].addActionListener(e -> {
                tfCount[id].setText(Integer.toString(Integer.parseInt(tfCount[id].getText()) + 1));
                orders[id]++;
                update();
            });
            pEast.add(bIncrease[i]);
        }
        pEast.setLayout(new GridLayout((items.length + 1), 3));
        pEast.setMaximumSize(new Dimension(225, 800));
        pCF.add(pEast, BorderLayout.EAST);

        /* ******************************* SOUTH ******************************** */
        JPanel pSouth = new JPanel();
        // Price
        JPanel pPrice = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel lTotalPrice = new JLabel("Total Price:");
        pPrice.add(lTotalPrice);
        lRawCost = new JLabel("Rp. " + nice(cost) + "K");
        pPrice.add(lRawCost);
        pSouth.add(pPrice);
        // Discount
        JPanel pDiscount = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel lDiscountState = new JLabel("Discount:");
        pDiscount.add(lDiscountState);
        String discount = (isDiscount) ? "15%" : "None";
        lIsDiscount = new JLabel(discount);
        pDiscount.add(lIsDiscount);
        pSouth.add(pDiscount);
        // Final Cost
        JPanel pCost = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel lFinalCostStatement = new JLabel("Final Cost:");
        pCost.add(lFinalCostStatement);
        double finalCost = (isDiscount) ? cost * 0.85 : cost;
        lFinalCost = new JLabel("Rp. " + nice(finalCost) + "K");
        pCost.add(lFinalCost);
        pSouth.add(pCost);
        // The rest
        pSouth.setLayout(new GridLayout(3, 1));
        pCF.add(pSouth, BorderLayout.SOUTH);

        /* ******************************* FRAME ******************************** */
        add(pCF);
        setSize(600, 400);
        setMinimumSize(new Dimension(600, 400));
        setMaximumSize(new Dimension(600, 400));
        setTitle("Welcome to Volgion Coffee Shop!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(new Color(99, 97, 107));
        setVisible(true);
    }

    static void update() {
        cost = 0;
        for (int i = 0; i < items.length; i++) {cost += orders[i] * prices[i];}
        lRawCost.setText("Rp. " + nice(cost) + "K");
        isDiscount = cost >= 100;
        discount = (isDiscount) ? "15%" : "None";
        lIsDiscount.setText(discount);
        finalCost = (isDiscount) ? cost * 0.85 : cost;
        lFinalCost.setText("Rp. " + nice(finalCost) + "K");
    }
    static String nice(double cc) {
        return (cc % 1 == 0) ? String.format("%.0f", cc) : String.format("%.1f", cc);
    }
    String noSpace(String ns) {
        return ns.replaceAll(" ", "");
    }
    void reset() {
        cost = 0;
        for (int i = 0; i < items.length; i++) {
            orders[i] = 0;
            tfCount[i].setText("0");
        }
        update();
    }

    public class Transaction extends JFrame {

        Transaction() {
            setLayout(new BorderLayout());
            /* ******************************* NORTH ******************************** */
            // Upper Half
            ImageIcon iiVolgion = new ImageIcon("Images/Volgion Logo.png");
            JLabel lVolgion = new JLabel(iiVolgion);
            JPanel pUpperNorth = new JPanel();
            pUpperNorth.add(lVolgion);
            // Lower Half
            String date = java.time.LocalDate.now().toString();
            JLabel lDate = new JLabel(date);
            String time = java.time.LocalTime.now().toString();
            JLabel lTime = new JLabel(time);
            JPanel pLowerNorth = new JPanel();
            pLowerNorth.add(lDate);
            pLowerNorth.add(lTime);
            pLowerNorth.setLayout(new FlowLayout(FlowLayout.CENTER));
            JLabel lThanks = new JLabel("Thank your for purchasing!");

            JPanel pNorth = new JPanel();
            pNorth.add(pUpperNorth);
            pNorth.add(pLowerNorth);
            pNorth.add(lThanks);
            pNorth.setLayout(new GridLayout(3, 1));

            /* ******************************** WEST ******************************** */
            JPanel pWest = new JPanel();

            /* ******************************* CENTER ******************************* */
            // Items list
            int orderCount = 0;
            for (int order : orders) if (order > 0) orderCount++;
            JPanel pCenter = new JPanel();
            JLabel lItem = new JLabel("Purchased:");
            pCenter.add(lItem);
            JLabel lCount = new JLabel("QTY:");
            pCenter.add(lCount);
            JLabel lPrice = new JLabel("Prices:");
            pCenter.add(lPrice);
            JLabel[] lItems = new JLabel[orderCount];
            JLabel[] lCounts = new JLabel[orderCount];
            JLabel[] lPrices = new JLabel[orderCount];
            int id = 0;
            for (int i = 0; i < orders.length; i++) {
                if(orders[i] > 0) {
                    lItems[id] = new JLabel(noSpace(items[i]));
                    pCenter.add(lItems[id]);
                    lCounts[id] = new JLabel(Integer.toString(orders[i]));
                    pCenter.add(lCounts[id]);
                    lPrices[id] = new JLabel(prices[i] + "K");
                    pCenter.add(lPrices[id]);
                    id++;
                }
            }
            // Total
            JPanel pTotal = new JPanel(new FlowLayout(FlowLayout.CENTER));
            JLabel lLTotal = new JLabel("Total:");
            pTotal.add(lLTotal);
            int sum = 0;
            for(int i = 0; i < orders.length; i++) {sum += prices[i]*orders[i];}
            JLabel lRTotal = new JLabel(Integer.toString(sum));
            pTotal.add(lRTotal);
            pCenter.add(pTotal);
            // Discount
            JLabel lLDiscount = new JLabel("Discount:");
            pCenter.add(lLDiscount);
            String discount;
            if(isDiscount) {discount = "15%";} else {discount = "None";}
            JLabel lRDiscount = new JLabel(discount);
            pCenter.add(lRDiscount);
            // Price
            JLabel lLPrice = new JLabel("Price:");
            pCenter.add(lLPrice);
            CoffeeShop.update();
            JLabel lRPrice = new JLabel(String.format("%.1f", finalCost));
            pCenter.add(lRPrice);

            pCenter.setLayout(new GridLayout(orderCount+1+3, 2));

            /* ******************************** EAST ******************************** */
            JPanel pEast = new JPanel();
            

            /* ******************************* SOUTH ******************************** */
            // JPanel pSouth = new JPanel();

            /* ******************************* FRAME ******************************** */
            add(pNorth, BorderLayout.NORTH);
            add(pWest, BorderLayout.WEST);
            add(pCenter, BorderLayout.CENTER);
            add(pEast, BorderLayout.EAST);
            // add(pSouth, BorderLayout.SOUTH);
            int width = 250; int height = 200+200+((orderCount+1)*30);
            setSize(width, height);
            setVisible(true);
            setTitle("Volgion Coffee Shop Struck");
        }
    }

    public static void main(String[] args) {
        // TODO: Add Login Page
        new CoffeeShop();
        // TODO: Integrate database for purchase history
        // TODO: Display history
        // TODO:
    }
}
