package autocompleter;

import java.awt.event.ActionEvent;
import java.util.Collections;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;

public class Autocomplete implements DocumentListener {
    
    private static enum Mode {
        INSERT,
        COMPLETION
    };

    private final JTextField textField;
    private final List<String> keywords;
    private Mode mode = Mode.INSERT;
  
  /**
   * Constructor.
   * 
   * @param textField TextField in which autocomplete is necessary.
   * @param keywords  The list for autocomplete words.
   */
    public Autocomplete(final JTextField textField, List<String> keywords) {
        this.textField = textField;
        this.keywords = keywords;
        Collections.sort(keywords);
    }

  /**
   * Gives notification that a portion of the document has been removed. 
   * 
   * @param event The document event.
   */
    @Override
    public void removeUpdate(final DocumentEvent event) {
        System.out.println("removeUpdate used");
    }
    
    /**
     * Gives notification that an attribute or set of attributes changed.
     * 
     * @param event The document event.
     */
    @Override
    public void changedUpdate(final DocumentEvent event) {
        System.out.println("changedUpdate used");
    }
    
    /**
     * Gives notification that there was an insert into the document. 
     * 
     * @param event The document event.
     */
    @Override
    public void insertUpdate(final DocumentEvent event) {
        String content = "test";
        if (event.getLength() != 1){
            return;
        }

        final int pos = event.getOffset();
        try {
            content = textField.getText(0, pos + 1);
        } catch (BadLocationException e) {
            e.printStackTrace(System.out);
        }

        // Find where the word starts.
        int word;
        for (word = pos; word >= 0; word--) {
          if (!Character.isLetter(content.charAt(word))) {
                break;
          }
        }

        // Too few chars.
        if (pos - word < 2){
            return;
        }
        
        fillCode(content, word, pos);
    }
    
    private void fillCode(String content, int word, int pos){
        String prefix = content.substring(word + 1).toLowerCase();
        int number = Collections.binarySearch(keywords, prefix);
        if (number < 0 && -number <= keywords.size()) {
            String match = keywords.get(-number - 1);
            if (match.startsWith(prefix)) {
                // A completion is found.
                final String completion = match.substring(pos - word);
                // We cannot modify Document from within notification,
                // so we submit a task that does the change later.
                SwingUtilities.invokeLater(new CompletionTask(completion, pos + 1));
            }
        } else {
            // Nothing found.
            mode = Mode.INSERT;
        }
    }

    public class CommitAction extends AbstractAction {
        /**
        * serialVersionUID.
        */
        private static final long serialVersionUID = 5794543109646743416L;
    
        /**
        * The actions when the user commits to the text.
        * 
        * @param event The trigger actionevent.
        */
       @Override
        public void actionPerformed(ActionEvent event) {
            try{
                if (mode == Mode.COMPLETION) {
                    int pos = textField.getSelectionEnd();
                    StringBuilder sb = new StringBuilder(textField.getText());
                    sb.insert(pos, "");
                    textField.setText(sb.toString());
                    textField.setCaretPosition(pos);
                    mode = Mode.INSERT;
                } else {
                    textField.replaceSelection("\t");
                }
            } catch (IllegalArgumentException e){
                System.out.println("IlegalArgumentException in CommitAction: " + e.getMessage());
            }
        }
    }

    private class CompletionTask implements Runnable {
        private final String completion;
        private final int position;
    
        /**
         * Constructor.
         * 
         * @param completion The string to complete.
         * @param position The positie of the string already typed.
         */
        CompletionTask(String completion, final int position) {
            this.completion = completion;
            this.position = position;
        }
    
        /**
         * Enter the text into the textfield.
         */
        @Override
        public void run() {
            try{
                StringBuilder builder = new StringBuilder(textField.getText());
                builder.insert(position, completion);
                textField.setText(builder.toString());
                textField.setCaretPosition(position + completion.length());
                textField.moveCaretPosition(position);
                mode = Mode.COMPLETION;
            } catch (IllegalArgumentException e){
                System.out.println("IlegalArgumentException in CompletionTask: " + e.getMessage());
            }
        }
    }
}
