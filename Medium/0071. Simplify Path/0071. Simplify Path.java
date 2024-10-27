class Solution {
    public String simplifyPath(String path) {
        final int len = path.length();
        int index = 0, tempIndex, moveIndex = 0;
        List<String> dataString = new ArrayList<>();
        while (true) {
            while (index < len && path.charAt(index) == '/') index++;
            if (index >= len) break;
            tempIndex = index;
            while (index < len && path.charAt(index) != '/') index++;
            if (index == tempIndex + 1 && path.charAt(tempIndex) == '.') continue;
            else if (index == tempIndex + 2 && path.charAt(tempIndex + 1) == '.' && path.charAt(tempIndex) == '.') {
                moveIndex--;
                if (moveIndex < 0) moveIndex = 0;
            } else {
                if (moveIndex >= dataString.size()) dataString.add(path.substring(tempIndex, index));
                else dataString.set(moveIndex, path.substring(tempIndex, index));
                moveIndex++;
            }
        }
        if (moveIndex == 0) return "/";
        StringBuilder sb = new StringBuilder();
        for (index = 0; index < moveIndex; index++) sb.append('/').append(dataString.get(index));
        return sb.toString();
    }
}
