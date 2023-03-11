# java 模板

### code filename

`$!velocityTool.camelCaseName(${question.titleSlug})Main`

### code template

```
${question.content}
  
package org.fade.leetcode.editor.cn;

public class $!velocityTool.camelCaseName(${question.titleSlug})Main {
      
    public static void main(String[] args) {
        Solution solution = new $!velocityTool.camelCaseName(${question.titleSlug})().new Solution();
    }
    
    #foreach( $line in $question.code.split("\r?\n") )
        #set($content = "${line}")
$content
    #end
    
}
```