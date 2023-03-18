class BrowserHistory {
    ArrayList<String> al;
    int currIndex, maxIndex;

    public BrowserHistory(String homepage) {
        al = new ArrayList<>();
        al.add(homepage);
        currIndex = 0;
        maxIndex = 0;
    }

    public void visit(String url) {
        if (currIndex == al.size()) {
            al.add(url);
            currIndex++;
        } else {
            al.add(++currIndex, url);
        }
        maxIndex = currIndex;
    }

    public String back(int steps) {
        if (currIndex - steps > 0) {
            currIndex -= steps;
        } else {
            currIndex = 0;
        }
        return al.get(currIndex);
    }

    public String forward(int steps) {
        if (currIndex + steps >= maxIndex) {
            currIndex = maxIndex;
        } else {
            currIndex += steps;
        }
        return al.get(currIndex);
    }
}
/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */
